CREATE TABLE IF NOT EXISTS anime (
    animeid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    description text,
    type text,
    year_release smallint,
    imageurl text);

CREATE TABLE author (
    authorid uuid NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
    name text,
    imageurl text);

