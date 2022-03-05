create table ingredient_in_recipe (
    id bigserial primary key,
    recipe_id bigserial not null,
    ingredient_id bigserial not null
);

create table user_rating (
    user_id bigserial not null,
    recipe_id bigserial not null,
    primary key (user_id, recipe_id)
);