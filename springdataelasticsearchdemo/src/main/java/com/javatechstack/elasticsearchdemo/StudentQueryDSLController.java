package com.javatechstack.elasticsearchdemo;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MultiMatchQuery.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentQueryDSLController {
	
	@Autowired
	ElasticsearchTemplate template;
	
	Student getStudent(){
		
		//template.
		return null;
		
	}
	
	
	@GetMapping("/dsl/all")
	 public List<Student> getAll(String text) {

	       /* QueryBuilder query = QueryBuilders.boolQuery()
	                .should(
	                        QueryBuilders.queryStringQuery(text)
	                                .lenient(true)
	                                .field("name")
	                                .field("teamName")
	                ).should(QueryBuilders.queryStringQuery("*" + text + "*")
	                        .lenient(true)
	                        .field("name")
	                        .field("teamName"));

	        NativeSearchQuery build = new NativeSearchQueryBuilder()
	                .withQuery(query)
	                .build();*/

	        List<Student> userses=null;// = template.queryForList(build, Student.class);

	        return userses;
	    }

}
