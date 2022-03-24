# Define function to validate isbn and returns a message, isbn number and a boolean
def validate_isbn(isbn):

    # Define variables
    len_isbn = len(isbn)
    total = 0

    # Determine list uses to validate and number used to validate based on length based on isbn
    # else return appropriate response
    if len_isbn == 10:
        validation_list = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
        divisible_num = 11

    elif len_isbn == 13:
        validation_list = [1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1]
        divisible_num = 10

    else:
        return "ISBN Number Is Not A Valid Length", isbn, False

    # Create for loop to get total used for validation
    for i in range(len_isbn):
        total += int(isbn[i]) * int(validation_list[i])

    # If isbn is valid and is an isbn10 number convert it and return values
    if total % divisible_num == 0:
        if len_isbn == 10:
            isbn = "978" + isbn

        return "ISBN Is A Valid Number", isbn, True

    # If none of the above conditions are met return appropriate values
    return "ISBN Is Not A Valid Number", isbn, False


# Validate isbn Number
message, returned_isbn, valid = validate_isbn("0330301624")

# Print appropriate response based on boolean
if valid:
    print(f"{message}\nISBN13: {returned_isbn}")
else:
    print(f"{message}\nISBN Entered: {returned_isbn}")
