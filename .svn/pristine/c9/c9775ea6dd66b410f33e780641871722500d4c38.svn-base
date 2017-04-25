UPDATE Contact C inner join Organization O on O.address_id=C.id SET C.organization_id=O.id;
UPDATE Organization SET address_id=null;
ALTER TABLE `training`.`Organization` DROP COLUMN `address_id`, DROP FOREIGN KEY `FK50104153D49E4B10`;
ALTER TABLE `training`.`Organization` DROP COLUMN `address_id`;
UPDATE Contact set active=1;