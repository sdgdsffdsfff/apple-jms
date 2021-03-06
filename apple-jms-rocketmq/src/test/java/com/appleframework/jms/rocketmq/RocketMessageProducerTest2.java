package com.appleframework.jms.rocketmq;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.appleframework.jms.rocketmq.producer.RocketMessageProducer4;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/spring-producer.xml" })
public class RocketMessageProducerTest2 {

	private static Logger logger = Logger.getLogger(RocketMessageProducerTest2.class.getName());
    
	@Resource
	private RocketMessageProducer4 messageProducer4;

	@Test
	public void testAddOpinion1() {
		try {
			for (int i = 0; i < 10; i++) {
				messageProducer4.sendText("xu", "i", i + "", "xuxuxuxuxu" + i);
			}
			logger.error("------------------");
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
