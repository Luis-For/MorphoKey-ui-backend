--modification to tables Domain, Kingdom, Phylum, Class, Order, Family, Genus, Species
ALTER TABLE taxokey."domain" ALTER COLUMN photo_url DROP NOT NULL;
ALTER TABLE taxokey."kingdom" ALTER COLUMN photo_url DROP NOT NULL;
ALTER TABLE taxokey."phylum" ALTER COLUMN photo_url DROP NOT NULL;
ALTER TABLE taxokey."class" ALTER COLUMN photo_url DROP NOT NULL;
ALTER TABLE taxokey."order" ALTER COLUMN photo_url DROP NOT NULL;
ALTER TABLE taxokey."family" ALTER COLUMN photo_url DROP NOT NULL;
ALTER TABLE taxokey."genus" ALTER COLUMN photo_url DROP NOT NULL;
ALTER TABLE taxokey."species" ALTER COLUMN photo_url DROP NOT NULL;

select *
from taxokey.domain