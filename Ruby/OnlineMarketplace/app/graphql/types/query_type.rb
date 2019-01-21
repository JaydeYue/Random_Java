Types::QueryType = GraphQL::ObjectType.define do
  name "Query"
  # Add root-level fields here.
  # They will be entry points for queries on your schema.

  # TODO: remove me
  field :allProducts do
    type types[Types::ProductType]
    description "A list of all the products"

    resolve -> (obj, args, ctx) {
      Product.all
    }
  end

  field :aProduct do
    type Types::ProductType
    description "Return a product"
    argument :title, !types.String

    resolve -> (obj, args, ctx) { Product.find(title: args[:title]) }
  end

  field :allProdcutsWithInventory do
    type types[Types::ProductType]
    description "Return all products with inventories left"

    resolve -> (obj, args, ctx) { Product.where(inventory_count: {gt: 0}) }
  end
end
