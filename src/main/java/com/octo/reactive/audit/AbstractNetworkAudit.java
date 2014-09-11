package com.octo.reactive.audit;

import com.octo.reactive.audit.lib.AuditReactiveException;
import com.octo.reactive.audit.lib.Latency;
import org.aspectj.lang.JoinPoint;

public class AbstractNetworkAudit extends AbstractAudit
{
	@Override
	protected AuditReactiveException newException(Latency latency, JoinPoint thisJoinPoint)
	{
		return FactoryException.newNetwork(latency, thisJoinPoint);
	}
}