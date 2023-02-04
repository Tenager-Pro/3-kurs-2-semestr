import psycopg2
from config import host, user, password, db_name

def get_account_user_id(id):
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
                """SELECT 
                    condition_account.name,
                    account.balance
                    FROM 
                    account,
                    condition_account
                    WHERE 
                    user_id = """+str(id)+""" 
                    And
                    account.condition_id=condition_account.id;"""
            )
            check_account = cursor.fetchall()
            return check_account
    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

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