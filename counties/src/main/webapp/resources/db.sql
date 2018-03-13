
DROP TABLE IF EXISTS `county`;
CREATE TABLE IF NOT EXISTS `county` (
  `id` int(11) NOT NULL,
  `population` int(11) DEFAULT NULL,
  `area_rank` int(11) DEFAULT NULL,
  `area_total` int(11) DEFAULT NULL,
  `neighbours_no` int(11) DEFAULT NULL,
  `capital` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `motto` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `county_has_neighbour`;
CREATE TABLE IF NOT EXISTS `county_has_neighbour` (
  `id` int(11) NOT NULL,
  `border_length` int(11) DEFAULT NULL,
  `county_id` int(11) DEFAULT NULL,
  `neighbour_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES
	(1, 194942, 14, 2342, 5, 'Navan', 'navan.jpg', 'Stronger Together', 'Meath', 'Leinster'),
	(2, 1345402, 30, 922, 3, 'Dublin', 'dublin.jpg', 'Action to match our speech', 'Dublin', 'Leinster'),
	(3, 128884, 32, 827, 5, 'Dundalk', 'louth.jpg', 'Lugh equally skilled in many arts', 'Louth', 'Leinster'),
	(4, 88770, 21, 1840, 6, 'Mulingar', 'westmith.jpg', 'Noble above nobility', 'Westmeath', 'Leinster'),
	(5, 64436, 11, 2648, 7, 'Roscommon', 'roscommon.jpg', 'Steadfast Irish heart', 'Roscommon', 'Connacht'),
   	(11, 128884, 32, 827, 3, 'Galway', 'louth.jpg', 'Galway is cool', 'Galway', 'Leinster');

INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('6', '618108', '9', '3046', '4', 'Antrim', 'antrim.jpg', 'Through Trial to Triumphs', 'Antrim', 'Ulster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `name`, `province`) VALUES ('7', '24272', '31', '897 ', '5', 'Carlow', 'carlow.jpg', 'Carlow', 'Leinster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('8', '76092', '29', '1932', '5', 'Cavan', 'cavan.jpg', 'Manliness and Truth', 'Cavan', 'Ulster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('9', '118627', '7', '3450', '4', 'Ennis', 'clare.jpg', 'True to our heritage', 'Clare', 'Munster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `name`, `province`) VALUES ('10', '542196', '1', '7500', '4', 'Cork', 'cork.jpg', 'Cork', 'Munster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `name`, `province`) VALUES ('12', '247132', '15', '2074', '4', 'Coleraine', 'derry.jpg', 'Londonderry', 'Ulster');

INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('13', '158755', '4', '4861', '3', 'Donegal', 'donegal.jpg', 'Have love for one another', 'Donegal', 'Ulster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('14', '531665', '12', '2466', '2', 'Downpatrick', 'down.jpg', 'Nothing Without Labour', 'Down', 'Ulster');
INSERT INTO `web_ass1`.`county` (`id`, `flag`, `name`) VALUES ('15', 'fermanagh.jpg', 'Fermanagh');
UPDATE `web_ass1`.`county` SET `population`='258552', `area_rank`='2', `area_total`='6149', `neighbours_no`='5', `flag`='galway.jpg', `motto`='Righteousness and Justice' WHERE `id`='11';

INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('16', '127554', '5', '4807', '2', 'Tralee', 'kerry.jpg', 'Co-operation, Help, Friendship', 'Kerry', 'Munster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('17', '222130', '24', '1695', '6', 'Naas', 'kildare.jpg', 'Spirit and Courage', 'Kildare', 'Leinster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('18', '95419', '333', '2073', '5', 'Kilkenny', 'kilkenny.jpg', 'The Marble City', 'Kilkenny', 'Leinster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('19', '84732', '23', '1720', '5', 'Port Laoise', 'laois.jpg', 'In partnership with the community', 'Laois', 'Leinster');

INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `name`, `province`) VALUES ('20', '31798', '26', '2590', '5', 'Carrick-on-Shannon', 'leitrim.jpg', 'Leitrim', 'Connacht');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('21', '195175', '10', '2756', '4', 'Limerick', 'limerick.jpg', 'Remember Limerick', 'Limerick', 'Munster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('22', '40810', '29', '1091', '4', 'Longford', 'longford.jpg', 'Strong and Loyal', 'Longford', 'Leinster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('23', '130638', '3', '5586', '4', 'Castlebar', 'mayo.jpg', 'God and Mary be with us', 'Mayo', 'Connacht');

INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('24', '60483', '28', '1295', '6', 'Monaghan', 'monaghan.jpg', 'Diligence and Best Endeavour', 'Monaghan', 'Ulster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('25', '78003', '18', '2001', '7', 'Tullamore', 'offly.jpg', 'Be Faithful', 'Offaly', 'Leinster');

INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('26', '65394', '22', '1838', '3', 'Sligo', 'sligo.jpg', 'Land of Heart\'s Desire', 'Sligo', 'Connacht');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `name`, `province`) VALUES ('27', '160441', '6', '4305', '8', '	Nenagh / Clonmel', 'tipperary.jpg', 'Tipperary', 'Munster');
INSERT INTO `web_ass1`.`county` (`id`, `name`) VALUES ('29', 'Tyrone');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `name`, `province`) VALUES ('30', '113795', '20', '1857', '4', 'Waterford', 'waterford.jpg', 'Waterford', 'Munster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('31', '149605', '13', '2365', '4', 'Wexford', 'wexford.jpg', 'An example to Ireland', 'Wexford', 'Munster');
INSERT INTO `web_ass1`.`county` (`id`, `population`, `area_rank`, `area_total`, `neighbours_no`, `capital`, `flag`, `motto`, `name`, `province`) VALUES ('32', '142332', '17', '2027', '4', 'Wicklow', 'wicklow.jpg', 'Free Spirits', 'Wicklow', 'Leinster');
