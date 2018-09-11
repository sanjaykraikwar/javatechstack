package com.javatechstack.elasticsearchdemo;




import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
 interface StudentRepository extends ElasticsearchRepository<Student, Integer> {

}
