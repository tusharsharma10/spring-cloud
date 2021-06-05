package com.cloud.repository.aerospike;

import org.springframework.data.aerospike.repository.AerospikeRepository;

import com.cloud.entity.aerospike.User;

public interface UserRepository extends AerospikeRepository<User, Integer> {

}
