Feature: ShoppingCart
  Como usuario quiero agregar/ quitar un producto a mi carrito de compras.
  Scenario: Agregar producto al carrito
    Given El usuario se encuentra en la pantalla de productos
    When El usuario agrega un producto a su carrito de compras con el boton ADD TO CART
    Then El usuario visualiza el icono carrito de compras con un producto cargado

  Scenario: Quitar producto del carrito
    Given El usuario se encuentra en la pantalla de productos
    When El usuario agrega un producto a su carrito de compras con el boton ADD TO CART
    Then El usuario quita un producto de su carrito de compras con el boton REMOVE