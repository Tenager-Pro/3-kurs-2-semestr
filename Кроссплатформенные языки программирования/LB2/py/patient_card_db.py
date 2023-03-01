import psycopg2
from config import host, user, password, db_name

def get_data_patient_card():
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
                number_card,
                create_date,
                name_proc,
                price,
                doctor_id,
                contract_id,
                total_price 
                FROM 
                patient_cards;"""
            )
            patient_card = cursor.fetchall()
            print(patient_card)
            return patient_card

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")


def get_data_patient_card_id(id):
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
                number_card,
                create_date,
                name_proc,
                price,
                doctor_id,
                contract_id,
                total_price  
                FROM 
                patient_cards
                Where
                id = """+str(id) +""";"""
            )
            patient_card = cursor.fetchall()
            return patient_card

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def get_name_doctor():
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
                doctors;"""
            )
            doctor = cursor.fetchall()
            return doctor

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def get_name_contract():
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
                number_contract
                FROM 
                contracts;"""
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
def get_ratio_doctor_id(id):
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
                ratio
                FROM 
                doctors
                Where
                id = """+id +""";"""
            )

            ratio = cursor.fetchone()
            print(ratio)
            return ratio

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")
def update_data_patient_card(id,number_card,create_date,name_proc,price,doctor_id,contract_id,total_price):
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
                patient_cards 
                set
                number_card= '"""+number_card+"""',
                create_date = '"""+str(create_date)+"""',
                name_proc= '"""+name_proc+"""',
                price = '"""+price+""""',
                doctor_id = '"""+doctor_id+""""',
                contract_id = '"""+contract_id+""""',
                total_price = '"""+total_price+""""'
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

def set_data_patient_card(number_card,create_date,name_proc,price,doctor_id, contract_id, total_price):
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
                """INSERT INTO patient_cards (
                number_card,
                create_date,
                name_proc,
                price,
                doctor_id,
                contract_id,
                total_price) VALUES
                ('""" + number_card + """', 
                '""" + str(create_date) + """', 
                 '""" + name_proc + """',
                 """ + str(price) + """,
                 """ + str(doctor_id) + """,
                 """ + str(contract_id) + """,
                 """ + str(total_price) + """);"""
            )
            print("[INFO] Data was succefully inserted")

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def delete_data_patient_card(id):
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
                """Delete from patient_cards 
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