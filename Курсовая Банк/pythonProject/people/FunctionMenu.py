import psycopg2
from config import host, user, password, db_name

def get_list_account(user_id):
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
                account.account_number,
                account.balance
                FROM
                account,
                condition_account 
                WHERE 
                account.user_id = """ + str(user_id) + """
                and
                account.condition_id = condition_account.id;"""
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
