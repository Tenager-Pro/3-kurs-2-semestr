import psycopg2
from config import host, user, password, db_name
def get_data_patient():
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
                id,
                name,
                birth_date,
                phone_number 
                FROM 
                patients;"""
            )
            patient = cursor.fetchall()
            print(patient)
            return patient

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")