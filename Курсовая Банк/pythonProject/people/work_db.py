import psycopg2
from User import User
from config import host, user, password, db_name

#User
def get_data_user(phone,user_password):
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
                """SELECT * FROM users WHERE phone = """ + phone + """;"""
            )
            check_user = cursor.fetchone()
            if check_user[5]==user_password:
                return check_user
            else:
                return []
    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")


def get_id_user(phone):
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
                """SELECT id FROM users WHERE phone = """ + phone + """;"""
            )
            check_user = cursor.fetchone()
            return check_user
    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")


def check_phone_in_db(phone):
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
                """SELECT * FROM users WHERE phone = """ + phone + """;"""
            )
            print("""SELECT * FROM users WHERE phone = """ + phone + """;""")
            print(cursor.fetchone())
            if cursor.fetchone()==None:
                return True
            else:
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
                ('""" + user_info.get_first_name() + """', '""" + user_info.get_last_name() + """', 
                 '""" + user_info.get_phone() + """', '""" + user_info.get_email() + """', 
                 '""" + user_info.get_password() + """');"""
            )
            print("[INFO] Data was succefully inserted")

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")



#Account
def get_data_account():
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
                """Select * from condition_account"""
            )
            print("[INFO] Data was succefully inserted")
            check_account = cursor.fetchall()
            return check_account

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")






#Account
def set_data_account(account):
    try:
        connection = psycopg2.connect(
            host=host,
            user=user,
            password=password,
            database=db_name
        )
        connection.autocommit = True

        with connection.cursor() as cursor:
            insert_query = """ INSERT INTO account (create_date, balance, condition_id,user_id,account_number)
                                         VALUES (%s, %s, %s,%s,%s)"""
            item_tuple = (account.get_create_date(), account.get_balance(),
                          account.get_condition_id(),account.get_user_id(),account.get_account_number())
            cursor.execute(insert_query, item_tuple)

            print("[INFO] Data was succefully inserted")
            print("[INFO] Счет создан")
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
