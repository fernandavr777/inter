Feature: Validacion de las funcionalidades de mis pagos en casa entregados
    Como [PO] quiero validar las funcionalidades del modulo msi pagos en casa entregados

    Background:
        Given Ingreso al portal clientes
        When Inicio sesion en el portal clientes
            And Ingreso al modulo de pago en casa entregados

    @Validar_la_funcionalidad_de_los_filtros
    Scenario: validar la funcionalidad de los filtros en el modulo mis pagos en casa entregados
            And Filtro por rango de fecha y estado
            And Valido el filtro de fecha y estado
            And Filtro buscar por -numero -estado
            And Valido el filtro buscar por -numero -estado 
            And Filtro -buscar por -numero -fecha -estado 
            Then valido el filtro -buscar por -numero -fecha -estado

