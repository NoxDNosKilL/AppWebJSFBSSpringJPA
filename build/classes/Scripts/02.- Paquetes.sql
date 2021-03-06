CREATE OR REPLACE 
PACKAGE PKG_PRODUCTO AS 

  PROCEDURE SP_LISTAR(
    P_CURSOR  OUT SYS_REFCURSOR,
    P_NOMBRE IN PRODUCTO.NOMBRE%TYPE
    
  );
  
  PROCEDURE SP_INSERTAR(
    P_ID_PRODUCTO   OUT PRODUCTO.ID_PRODUCTO%TYPE,
    P_NOMBRE        IN  PRODUCTO.NOMBRE%TYPE,
    P_STOCK         IN  PRODUCTO.STOCK%TYPE,
    P_PRECIO        IN  PRODUCTO.PRECIO%TYPE
  );
  
  PROCEDURE SP_ACTUALIZAR(
    P_ID_PRODUCTO   IN  PRODUCTO.ID_PRODUCTO%TYPE,
    P_NOMBRE        IN  PRODUCTO.NOMBRE%TYPE,
    P_STOCK         IN  PRODUCTO.STOCK%TYPE,
    P_PRECIO        IN  PRODUCTO.PRECIO%TYPE
  );
  
  PROCEDURE SP_ELIMINAR(
    P_ID_PRODUCTO   IN  PRODUCTO.ID_PRODUCTO%TYPE
  );
  
  
END PKG_PRODUCTO;




CREATE OR REPLACE
PACKAGE BODY PKG_PRODUCTO AS 
  PROCEDURE SP_LISTAR(
    P_CURSOR  OUT SYS_REFCURSOR,
    P_NOMBRE IN PRODUCTO.NOMBRE%TYPE
    
  ) AS
  BEGIN
        OPEN
            P_CURSOR
        FOR
            SELECT
                ID_PRODUCTO,
                NOMBRE,
                STOCK,
                PRECIO
            FROM
                PRODUCTO
            WHERE
                    UPPER(NOMBRE)  LIKE '%'||UPPER(P_NOMBRE)||'%'
            AND ESTADO=1; 
  END SP_LISTAR;
  
  PROCEDURE SP_INSERTAR(
    P_ID_PRODUCTO   OUT PRODUCTO.ID_PRODUCTO%TYPE,
    P_NOMBRE        IN  PRODUCTO.NOMBRE%TYPE,
    P_STOCK         IN  PRODUCTO.STOCK%TYPE,
    P_PRECIO        IN  PRODUCTO.PRECIO%TYPE
  )AS
  BEGIN
        SELECT
            SEQ_PRODUCTO.NEXTVAL
        INTO
            P_ID_PRODUCTO
        FROM
            DUAL;
  
        INSERT INTO 
            PRODUCTO
        (
            ID_PRODUCTO,
            NOMBRE,
            STOCK,
            PRECIO,
            ESTADO
        )
        VALUES
        (
            P_ID_PRODUCTO,
            P_NOMBRE,
            P_STOCK,
            P_PRECIO,
            '1'
        );
  END SP_INSERTAR;
  
  PROCEDURE SP_ACTUALIZAR(
    P_ID_PRODUCTO   IN  PRODUCTO.ID_PRODUCTO%TYPE,
    P_NOMBRE        IN  PRODUCTO.NOMBRE%TYPE,
    P_STOCK         IN  PRODUCTO.STOCK%TYPE,
    P_PRECIO        IN  PRODUCTO.PRECIO%TYPE
  )AS
  BEGIN
        UPDATE
            PRODUCTO
        SET
            NOMBRE      =   P_NOMBRE,
            STOCK       =   P_STOCK,
            PRECIO      =   P_PRECIO
        WHERE
            ID_PRODUCTO =   P_ID_PRODUCTO;

  END SP_ACTUALIZAR;
  
  PROCEDURE SP_ELIMINAR(
    P_ID_PRODUCTO   IN  PRODUCTO.ID_PRODUCTO%TYPE
  )AS
  BEGIN
        UPDATE
            PRODUCTO
        SET
            ESTADO      =   '0'
        WHERE
            ID_PRODUCTO =   P_ID_PRODUCTO;

  END SP_ELIMINAR;

  
END PKG_PRODUCTO;

