package com.example.BookManagementSystemUsingSpringJDBC.Entity;

import jakarta.validation.constraints.*;

public class Book {
    private Long id;
    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Author is required")
    private String author;

    @Min(value = 1900, message = "Year must be valid")
    private int publicationYear;
    // Constructors, Getters, Setters
    public Book() {}

   

	public Book(Long id, String title, String author, int publicationYear) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
    
    
}
