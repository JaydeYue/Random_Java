# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)

Product.create(
  title: "Chips",
  price: 3,
  inventory_count: 10
)

Product.create(
  title: "Collars",
  price: 10,
  inventory_count: 5
)

Product.create(
  title: "Bottles",
  price: 7,
  inventory_count: 7
)

Product.create(
  title: "Books",
  price: 20,
  inventory_count: 2
)
