Feature: Registro e inicio de sesion en el portal clientes
    Como [PO] quiero validar el registro e inicio de sesion del portal clientes

    Background:
        Given Ingreso al portal clientes

    @Registro_de_usuario_portal_clientes
    Scenario: Registro de usuario en el portal clientes
        When Realizo el proceso de registro de usuario
        Then Valido el registro exitoso del usuario

    @Inicio_de_sesion_portal_clientes
    Scenario: Inicio de sesión en el portal clientes
        When Inicio sesion en el portal clientes
        Then valido inicio de sesion en el portal

    @Validacion_datos_de_la_cuenta
    Scenario: Validar los datos de la cuenta
        When Inicio sesion en el portal clientes
        Then Valido los datos de la cuenta



