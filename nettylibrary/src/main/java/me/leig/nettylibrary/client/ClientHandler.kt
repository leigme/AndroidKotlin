/**********************************************************************
 *	湖南长沙阳环科技实业有限公司
 *    @Copyright (c) 2003-2017 yhcloud, Inc. All rights reserved.
 *
 *	This copy of Ice is licensed to you under the terms described in the
 *	ICE_LICENSE file included in this distribution.
 *
 *	@license http://www.yhcloud.com.cn/license/
 **********************************************************************/
package me.leig.nettylibrary.client

import android.util.Log
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import me.leig.nettylibrary.comm.NettyMessage

/**
 *
 *
 *
 * @author Leig
 * @version 20180301
 *
 */

class ClientHandler: SimpleChannelInboundHandler<NettyMessage>() {

    private val tag = ClientHandler::class.java.name

    override fun channelRead0(ctx: ChannelHandlerContext, msg: NettyMessage) {
        Log.i(tag, "读取成功...")
    }

    override fun channelActive(ctx: ChannelHandlerContext) {
        Log.i(tag, "连接成功...")
    }

    override fun channelInactive(ctx: ChannelHandlerContext) {
        Log.i(tag, "连接断开...")
    }

}