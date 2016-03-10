package com.appleframework.jms.kafka.producer;

import java.io.Serializable;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;

import com.appleframework.jms.core.exception.JmsException;
import com.appleframework.jms.core.exception.MQException;
import com.appleframework.jms.core.producer.MessageProducer2;
import com.appleframework.jms.core.utils.ByteUtils;

/**
 * @author Cruise.Xu
 * 
 */
public class KafkaMessageProducer2 implements MessageProducer2 {

	private Producer<String, byte[]> producer;
	private String topic;

	public void setProducer(Producer<String, byte[]> producer) {
		this.producer = producer;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	@Override
	public void sendByte(String key, byte[] message) throws JmsException {
		try {
			KeyedMessage<String, byte[]> producerData 
				= new KeyedMessage<String, byte[]>(topic, key, message);
			producer.send(producerData);
		} catch (Exception e) {
			throw new MQException(e);
		}
	}

	@Override
	public void sendObject(String key, Serializable message) throws JmsException {
		try {
			KeyedMessage<String, byte[]> producerData 
				= new KeyedMessage<String, byte[]>(topic, key, ByteUtils.toBytes(message));
			producer.send(producerData);
		} catch (Exception e) {
			throw new MQException(e);
		}
	}

	@Override
	public void sendText(String key, String message) throws JmsException {
		try {
			KeyedMessage<String, byte[]> producerData 
				= new KeyedMessage<String, byte[]>(topic, key, ByteUtils.toBytes(message));
			producer.send(producerData);
		} catch (Exception e) {
			throw new MQException(e);
		}
	}	

}
