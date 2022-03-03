create table ingredient_in_recipe (
    id bigserial primary key,
    recipe_id bigserial not null,
    ingredient_id bigserial not null
);