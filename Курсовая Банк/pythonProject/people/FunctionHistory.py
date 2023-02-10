import psycopg2
from config import host, user, password, db_name
from Converting import *


def get_list_history_all(user_id):
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
                """
                Select
                *
                From
                (SELECT 
                condition_account.name,
                account_history.old_val,
                account_history.new_val,
                account_history.edit_time
                FROM
                account,
                account_history,
                condition_account
                WHERE 
                account_history.user_id = """ + str(user_id) + """
                and
                account.condition_id = condition_account.id
                and
                account_history.account_id = account.id
                ORDER by account_history.id DESC
                LIMIT 5) as history
                Order by history asc;"""

            )
            list_account = cursor.fetchall()
            if list_account == None:
                return ()
            else:
                return list_account
    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def get_list_history_about_account(user_id,text):
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
                """
                Select
                *
                From
                (SELECT 
                condition_account.name,
                account_history.old_val,
                account_history.new_val,
                account_history.edit_time
                FROM
                account,
                account_history,
                condition_account
                WHERE 
                account_history.user_id = """ + str(user_id) + """
                and
                condition_account.name = '""" + text + """'
                and
                account.condition_id = condition_account.id
                and
                account_history.account_id = account.id
                ORDER by account_history.id DESC
                LIMIT 5) as history
                Order by history asc;"""

            )
            list_account = cursor.fetchall()
            if list_account == None:
                return ()
            else:
                return list_account
    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")