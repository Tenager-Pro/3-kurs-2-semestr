import psycopg2
from config import host, user, password, db_name

def get_data_contract():
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
                number_contract,
                total_cost,
                create_date,
                patient_id 
                FROM 
                contracts;"""
            )
            contract = cursor.fetchall()
            print(contract)
            return contract

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def get_data_contract_id(id):
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
                number_contract,
                total_cost,
                create_date,
                patient_id
                FROM 
                contracts
                Where
                id = """+str(id) +""";"""
            )
            contract = cursor.fetchall()
            return contract

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def get_name_patient():
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
                name
                FROM 
                patients;"""
            )
            patient = cursor.fetchall()
            return patient

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def update_data_contract(id,number_contract,total_cost,create_date,patient_id):
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
                """Update 
                contracts 
                set
                number_contract= '"""+number_contract+"""',
                total_cost = '"""+str(total_cost)+"""',
                create_date = '"""+str(create_date)+"""',
                patient_id = '"""+str(patient_id)+"""'
                where
                id = """ + str(id) + """;"""
            )
            print("[INFO] Data was succefully update")

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def set_data_contract(number_contract,total_cost,create_date,patient_id):
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
                """INSERT INTO contracts (
                number_contract,
                total_cost,
                create_date,
                patient_id) VALUES
                ('""" + number_contract + """',
                '""" + str(total_cost) + """', 
                '""" + str(create_date) + """', 
                 """ + str(patient_id) + """);"""
            )
            print("[INFO] Data was succefully inserted")

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def delete_data_contract(id):
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
                """Delete from contracts 
                Where id = """ + id + """;"""
            )
            print("[INFO] Data was succefully delete")

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")