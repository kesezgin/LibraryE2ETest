Feature: As a librarian I should be able to edit books

  1-Librarian can edit books
  2- Edit book should have following parameters: name,
  author, description, category, ISBN, year.
  3- ISBN must be 10 or 13 digits in length and consists of digits (0-9) and dashes (-).
  4-Year parameter should have only digits (0-9)
  5-Following categories should be present:
  - Action and Adventure  - Anthology  - Classic  - Comic and Graphic Novel  - Crime and Detective
  - Drama  - Fable  - Fairy Tale  - Fan-Fiction  - Fantasy  - Historical Fiction  - Horror
  - Science Fiction  - Biography/Autobiography  - Humor  - Romance  - Short Story  - Essay
  - Memoir  - Poetry
  6-Librarian can select related category to see all books in that category by using book categories dropdown.
  7-Librarian can use show records dropdown for getting number of entries depends the dropdown options.
  8-Librarian can find book by using search box with book's Name and Author.

  @db @ui @api
  Scenario Outline: Librarian can edit a book with valid values
    Given Librarian is logged in the application
    When Librarian clicks Books button
    And Clicks the 1. Edit Book button to edit the book
    And Enters "<bookName>" "<ISBN>" <year> "<authorName>" "<bookCategory>" and "<description>"
    And Clicks Save changes button
    Then Librarian sees the update successful message
    And The updated book is returned by API
    And The updated book exists in database
    And Librarian logs out successfully
    Examples:
      | bookName            | ISBN           | year | authorName   | bookCategory            | description               |
      | Friedrich Nietzsche | 978-0521871174 | 2010 | Julian Young | Biography/Autobiography | A Philosophical Biography |