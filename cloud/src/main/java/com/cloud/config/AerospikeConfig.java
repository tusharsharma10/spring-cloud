package com.cloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.core.AerospikeTemplate;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aerospike.client.AerospikeClient;
import com.aerospike.client.policy.ClientPolicy;

@Configuration
@EnableTransactionManagement
@EnableAerospikeRepositories(basePackages = "com.cloud.repository.aerospike")
public class AerospikeConfig {

	@Autowired 
	InjectProperties properties;
	
	
	private static final String namespace = "test";
	
	@Bean
	AerospikeClient aerospikeClient() {
		
		ClientPolicy clientPolicy = new ClientPolicy();
		clientPolicy.failIfNotConnected = true;
		
		return new AerospikeClient(clientPolicy,properties.getIpAddress(),properties.getPort());
	}
	
	@Bean
	AerospikeTemplate aerospikeTemplate() {
		return new AerospikeTemplate(aerospikeClient(), namespace);
	}
	
}
