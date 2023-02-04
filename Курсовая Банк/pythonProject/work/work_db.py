import psycopg2
from User import User
from config import host, user, password, db_name
from PyQt5.QtWidgets import QMessageBox

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
            check_user = cursor.fetchall()
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
                """SELECT * FROM users WHERE phone = '""" + phone + """';"""
            )
            if cursor.fetchone()==[]:
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

def set_data_account(name,count_month,percentage,min_sum,is_replenishment,is_withdrawal):
    # insert data into a table
    print(is_replenishment)
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
                """INSERT INTO condition_account (name,count_month,percentage,min_sum,is_replenishment,is_withdrawal) VALUES
                ('""" + name + """', '""" + count_month + """', 
                 '""" + percentage + """', '""" + min_sum + """', 
                 '""" + str(is_replenishment) + """', '""" + str(is_withdrawal) + """');"""
            )
            print("[INFO] Data was succefully inserted")
            msg = QMessageBox()
            msg.setIcon(QMessageBox.Information)
            msg.setText("Info")
            msg.setInformativeText('Счет создан')
            msg.setWindowTitle("Info")
            msg.exec_()

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
