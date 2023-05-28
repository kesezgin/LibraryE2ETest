Feature: As a librarian I should be able to edit books

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
