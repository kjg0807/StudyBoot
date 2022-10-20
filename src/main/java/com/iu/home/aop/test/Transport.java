package com.iu.home.aop.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Transport
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public void takeBus()
	{
		log.info("----- 버스 타기 -----");
	}

	public void takeSubway()
	{
		log.info("----- 지하철 타기 -----");
	}

	public void getTaxi()
	{
		log.info("----- 택시 타기 -----");
	}

	public void plane()
	{
		log.info("----- 비행기 타기 -----");
	}
}
