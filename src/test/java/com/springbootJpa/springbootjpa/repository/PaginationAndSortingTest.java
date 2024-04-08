package com.springbootJpa.springbootjpa.repository;

import com.springbootJpa.springbootjpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void Pagination(){
        int pageNo = 0;
        int pageSize = 5;

        // create pageable object. After every 5 product a new Pageable object will be created
        Pageable pageable = PageRequest.of(pageNo,pageSize);

        // findAll method and pass pageable instance, each pageable object will be passed to each new page
        Page<Product> page = productRepository.findAll(pageable);

        // getContent() is to get 5 products of each page created in above line
        List<Product> products = page.getContent();

        products.forEach((p) ->{
            System.out.println(p);
        });

        // total pages
        int totalPage = page.getTotalPages();
        // total elements
        long totalElements = page.getTotalElements();
        // number of elements in each page
        int numberOfElements = page.getNumberOfElements();
        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();
        // first
        boolean isFirst = page.isFirst();
        System.out.println("total page -> " + totalPage);
        System.out.println("totalElements -> " + totalElements);
        System.out.println("numberOfElements -> " + numberOfElements);
        System.out.println(" size ->" + size);
        System.out.println(" isLast -> " + isLast);
        System.out.println(" isFirst -> " + isFirst);
    }

    @Test
    void Sorting(){
        String sortBy = "price";
        String sortDir = "asc";

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending() :Sort.by(sortBy).descending();

        List<Product> products = productRepository.findAll(sort);
//        List<Product> products = productRepository.findAll(Sort.by(sortBy).ascending());

        products.forEach((p) ->{
            System.out.println(p);
        });

    }

    @Test
    void SortingByMultipleFields(){
        String sortByName = "name";
        String sortByDescription = "description";
        String sortDir = "descendi";

        Sort sortName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortByName).ascending() :Sort.by(sortByName).descending();

        Sort sortDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortByDescription).ascending() :Sort.by(sortByDescription).descending();

        Sort groupBySort = sortName.and(sortDescription);

        List<Product> products = productRepository.findAll(groupBySort);
//        List<Product> products = productRepository.findAll(Sort.by(sortBy).ascending());

        products.forEach((p) ->{
            System.out.println(p);
        });

    }

    @Test
    void paginationAndSortingTogether(){

        String sortBy = "price";
        String sortDir = "desc";
        int pageNo = 1;
        int pageSize = 5;

        // Sort object
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();

        // Pageable object
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach((p) ->{
            System.out.println(p);
        });

        // total pages
        int totalPage = page.getTotalPages();
        // total elements
        long totalElements = page.getTotalElements();
        // number of elements
        int numberOfElements = page.getNumberOfElements();
        // size
        int size = page.getSize();

        // last
        boolean isLast = page.isLast();
        // first
        boolean isFirst = page.isFirst();
        System.out.println("total page -> " + totalPage);
        System.out.println("totalElements -> " + totalElements);
        System.out.println("numberOfElements -> " + numberOfElements);
        System.out.println(" size ->" + size);
        System.out.println(" isLast -> " + isLast);
        System.out.println(" isFirst -> " + isFirst);
    }

}
