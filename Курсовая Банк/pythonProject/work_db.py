import psycopg2
from User import User
from config import host, user, password, db_name


def get_data_user(phone):
    try:
        connection = psycopg2.connect(
            host=host,
            user=user,
            password=password,
            database=db_name
        )
        connection.autocommit = True
        # get data from a table
        with connection.cursor() as cursor:
            cursor.execute(
                """SELECT * FROM users WHERE phone = '""" + phone + """';"""
            )
            if cursor.fetchone()==None:
                print("2")
                return True
            else:
                print("1")
                return False
    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")


def set_data_user(user_info):
    # insert data into a table
    try:
        connection = psycopg2.connect(
            host=host,
            user=user,
            password=password,
            database=db_name
        )
        connection.autocommit = True

        with connection.cursor() as cursor:
            cursor.execute(
                """INSERT INTO users (first_name, last_name,phone,email,password) VALUES
                ('""" + user_info.getFirstName() + """', '""" + user_info.getLastName() + """', 
                 '""" + user_info.getPhone() + """', '""" + user_info.getEmail() + """', 
                 '""" + user_info.getPassword() + """');"""
            )
            print("[INFO] Data was succefully inserted")

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

    # # create a new table
    #     with connection.cursor() as cursor:
    #         cursor.execute(
    #             """CREATE TABLE Users(
    #                 id serial PRIMARY KEY,
    #                 first_name varchar(50) NOT NULL,
    #                 last_name varchar(50) NOT NULL,
    #                 phone int NOT NULL,
    #                 email varchar(50) NOT NULL,
    #                 password varchar(50) NOT NULL);"""
    #         )
    #         print("[INFO] Table created successfully")

    # delete a table
    # with connection.cursor() as cursor:
    #     cursor.execute(
    #         """DROP TABLE users;"""
    #     )

    #     print("[INFO] Table was deleted")
