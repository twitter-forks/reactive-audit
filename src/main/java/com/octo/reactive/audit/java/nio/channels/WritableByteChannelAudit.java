package com.octo.reactive.audit.java.nio.channels;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.nio.channels.SelectableChannel;

import static com.octo.reactive.audit.lib.Latency.HIGH;

/**
 * Created by pprados on 18/06/2014.
 */
@Aspect
public class WritableByteChannelAudit extends AbstractChannelsAudit
{
	@Before("call(int java.nio.channels.WritableByteChannel+.write(java.nio.ByteBuffer))")
	public void write(JoinPoint thisJoinPoint)
	{
		if (thisJoinPoint.getTarget() instanceof SelectableChannel)
		{
			if (!((SelectableChannel) thisJoinPoint.getTarget()).isBlocking())
				return;
		}
		latency(HIGH, thisJoinPoint);
	}

}