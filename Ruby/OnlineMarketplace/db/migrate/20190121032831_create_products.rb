class CreateProducts < ActiveRecord::Migration[5.2]
  def change
    create_table :products do |t|
      t.string :title
      t.string :price
      t.string :inventory_count

      t.timestamps
    end
  end
end
