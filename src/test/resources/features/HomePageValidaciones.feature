Feature: Validaciones de enlaces en el homepage del portal clientes
    Como [PO] quiero validar los enlaces del portal clientes

    @Validacion_de_enlaces_homepage_portal_clientes
    Scenario: Validar los enlaces del portal clientes
        Given Ingreso al portal clientes
        When Inicio sesion en el portal clientes
            And Me Encuentro en el homepage
        Then Valido el enlace de la tarjeta -pago en casa-
        Then Valido el enlace de la tarjeta -sigue tus envios-
        Then Valido el enlace de la tarjeta -mis pagos en casa entregados-
        Then Valido el enlace de la tarjeta -cotiza tu envio-
        Then Valida el enlace de la tarjeta -estamos muy cerca de ti-
        Then Valida el enlace de la tarjeta -solicita tu recogida-


