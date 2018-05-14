package io.titan.net.channel;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.titan.net.codec.fs.FileServerDecoder;

/**
 * A {@link ChannelInitializer} used for handling a channel's tasks.
 * @author Professor Oak
 */
public final class PipelineFactory extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		final ChannelPipeline pipeline = channel.pipeline();
				
		pipeline.addLast("decoder", new FileServerDecoder());
		pipeline.addLast("timeout", new IdleStateHandler(15, 0, 0));
		pipeline.addLast("handler", new ChannelHandler());
	}
}
