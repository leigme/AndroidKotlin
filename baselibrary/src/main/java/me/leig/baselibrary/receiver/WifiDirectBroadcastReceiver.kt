package me.leig.baselibrary.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager
import android.util.Log
import android.net.NetworkInfo

/**
 * Wifi P2P重要事件的广播
 *
 * @author Leig
 * @version 20180301
 *
 */

class WifiDirectBroadcastReceiver constructor(
        private val manager: WifiP2pManager,
        private val channel: WifiP2pManager.Channel,
        private val directActionListener: DirectActionListener): BroadcastReceiver() {

    private val tag = WifiDirectBroadcastReceiver::class.java.name

    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action) {
            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION -> {
                val stat = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1)
                if (WifiP2pManager.WIFI_P2P_STATE_ENABLED == stat) {
                    Log.i("tag", "Wifi p2p已经启动")
                    directActionListener.wifiP2pEnabled(true)
                } else {
                    Log.i("tag", "Wifi p2p没有启动")
                    directActionListener.wifiP2pEnabled(false)
                    val wifiP2pDeviceList = mutableListOf<WifiP2pDevice>()
                    directActionListener.onPeersAvailable(wifiP2pDeviceList)
                }
            }
            WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION -> {
                manager.requestPeers(channel) {
                    directActionListener.onPeersAvailable(it.deviceList)
                }
            }
            WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION -> {
                val networkInfo = intent.getParcelableExtra(WifiP2pManager.EXTRA_NETWORK_INFO) as NetworkInfo
                if (networkInfo.isConnected) {
                    manager.requestConnectionInfo(channel) {
                        directActionListener.onConnectionInfoAvailable(it)
                    }
                    Log.i(tag, "已经连接p2p设备")
                } else {
                    directActionListener.onDisconnection()
                    Log.i(tag, "与p2p设备已断开连接")
                }
            }
            WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION -> {
                directActionListener.onSelfDeviceAvailable(intent.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE) as WifiP2pDevice)
            }
        }
    }

}