--Function for delete all tables

DO
$$
DECLARE
    r RECORD;
BEGIN
    FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = 'taxokey') LOOP
        EXECUTE 'DROP TABLE IF EXISTS taxokey.' || quote_ident(r.tablename) || ' CASCADE';
    END LOOP;
END
$$;

-- Delete one table
DROP TABLE IF EXISTS nombre_tabla CASCADE;

-- Delete a register of a table
DELETE FROM nombre_tabla
WHERE columna_id = valor;

--Delete column
ALTER TABLE nombre_tabla
DROP COLUMN nombre_columna;

--Delete a row
DELETE FROM nombre_tabla;

