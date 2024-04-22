Feature: Validacion de las funcionalidades de pagos en casa
    Como [PO] quiero validar las funcionalidades del modulo pago en casa

    Background:
        Given Ingreso al portal clientes
        When Inicio sesion en el portal clientes
            And Ingreso al modulo de pago en casa

    @Inscribir_nueva_cuenta_bancaria_y_definirla
    Scenario: validar la funcionalidad de inscrbir una nueva cuenta bancaria y definirla
            And Inscribo una nueva cuenta
            And Confirmo los datos y creo la cuenta bancaria
            And Busco la cuenta bancaria en la tabla
            And Defino la cuenta bancaria
            And Veo la informacion de la cuenta y valido los datos
        Then Valido que la cuenta bancaria este difinida en la tabla

    @Inscribir_varias_cuentas_bancarias
    Scenario: validar la funcionalidad de inscrbir una nueva cuenta bancaria
            And Inscribo una nueva cuenta
            And Confirmo los datos y creo la cuenta bancaria
            And Busco la cuenta bancaria en la tabla

    @Definir_cuenta_bancaria
    Scenario: validar la funcionalidad de definir cuenta bancaria
            And Busco la cuenta bancaria para definirla en la tabla
            And Defino la cuenta bancaria ya inscrita
            And Veo la informacion de la cuenta y valido algunos datos
        Then Valido que la cuenta bancaria inscrita este definida en la tabla

    @Editar_cuenta_bancaria
    Scenario: validar la funcionalidad de editar cuenta bancaria
            And Busco la cuenta bancaria
            And Edito la cuenta bancaria y valido los datos actualizados en la pagina de confirmacion
            And Valido que la cuenta bancaria editada se encuentra en la tabla
                
    @Eliminar_cuenta_bancaria_inscrita
    Scenario: validar la funcionalidad de eliminar cuenta bancaria
            And Busco la cuenta bancaria para eliminar 
            And Elimino la cuenta bancaria
        Then Valido que la cuenta bancaria no se encuentra en la tabla










