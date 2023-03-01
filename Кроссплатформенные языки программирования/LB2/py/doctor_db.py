import psycopg2
from config import host, user, password, db_name

def get_data_doctor():
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
                ratio,
                post,
                phone_number 
                FROM 
                doctors;"""
            )
            doctor = cursor.fetchall()
            print(doctor)
            return doctor

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")
def get_data_doctor_id(id):
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
                ratio,
                post,
                phone_number
                FROM 
                doctors
                Where
                id = """+str(id) +""";"""
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
def update_data_doctor(id,name,ratio,post,phone_number):
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
                doctors 
                set
                name = '"""+name+"""',
                ratio = """+str(ratio)+""",
                post = '"""+post+"""',
                phone_number = '"""+phone_number+"""'
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

def set_data_doctor(name,ratio,post,phone_number):
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
            print("""INSERT INTO doctors (name,
                ratio,
                post,
                phone_number) VALUES
                ('""" + name + """', 
                """ + str(ratio) + """,
                 '""" + post + """',
                 '""" + phone_number + """');""")
            cursor.execute(
                """INSERT INTO doctors (name,
                ratio,
                post,
                phone_number) VALUES
                ('""" + name + """', 
                """ + str(ratio) + """,
                 '""" + post + """',
                 '""" + phone_number + """');"""
            )
            print("[INFO] Data was succefully inserted")

    except Exception as _ex:
        connection = False
        print("[INFO] Error while working with PostgreSQL", _ex)
    finally:
        if connection:
            connection.close()
            print("[INFO] PostgreSQL connection closed")

def delete_data_doctor(id):
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
                """Delete from doctors 
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