package com.boot.om.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.boot.om.entities.Student;
import com.boot.om.repo.StudentRepo;

@Component
public class StudentRunner implements CommandLineRunner {

	@Autowired
	private StudentRepo repo;

	@Override
	public void run(String... args) throws Exception {

		repo.saveAll(Arrays.asList(new Student("aa", "c", 23.6),
				new Student("bb", "java", 26.6),
				new Student("dd", "JSp", 28.6), 
				new Student("FF", "Servlet", 13.6),
				new Student("kk", "Spring", 0343.6),
				new Student("sdde", "boot", 28.6),
                new Student("zdFF", "Thread", 1343.6),
				new Student("iudd", "Help", 2348.6), 
				new Student("weFF", "RLangugae", 13.6)));
		
		System.out.println("1)==============================================");
		repo.findAll().forEach(System.out::println);

		System.out.println("2)==============================================");
		Optional<Student> opt = repo.findById(3L);
		if (opt.isPresent()) {
			System.out.println(opt.get().getSname());
		}

		System.out.println("sort)==============================================");

		Sort sort = Sort.by(Direction.ASC, "course");
		repo.findAll(sort).forEach(System.out::println);

		System.out.println("pageable)==============================================");

		Pageable pageable = PageRequest.of(0, 2);
		Page<Student> pageInput = repo.findAll(pageable);
		
		List<Student> content = pageInput.getContent();
		content.forEach(System.out::println);		
		System.out.println("vairous methods)==============================================");
		System.out.println("Total Numbers "+pageInput.getNumberOfElements());
		System.out.println("Page size     "+pageInput.getSize());
		System.out.println("Next page ?   "+pageInput.hasNext());
		System.out.println("Perivous page?"+pageInput.hasPrevious());
		System.out.println("Numbers       "+pageInput.getNumber());
		System.out.println("Total pages   "+pageInput.getTotalPages());


	}

}
