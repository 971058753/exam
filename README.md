CREATE TABLE `BAS_WLJCXXSZ` (
`WLID` int(4) NOT NULL AUTO_INCREMENT,
`WLDH` varchar(20) NOT NULL,
`WLMC` varchar(50) NOT NULL,
`WLGG` varchar(50) NOT NULL,
`WLDW` varchar(10) NOT NULL,
`TPLJ` varchar(50) NOT NULL,
`DM_SHZT` tinyint(2) DEFAULT '0',
PRIMARY KEY (`WLID`),
UNIQUE KEY `WLDH_UNIQUE` (`WLDH`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CJGK_DJMX` (
`MXID` int(4) NOT NULL AUTO_INCREMENT,
`DJID` int(4) NOT NULL,
`KCID` int(4) NOT NULL,
`WLID` int(4) NOT NULL,
`PH` varchar(20) NOT NULL,
`SL` int(4) NOT NULL DEFAULT '0',
`DJ` decimal(18,6) NOT NULL DEFAULT '0.000000',
`JE` decimal(18,2) NOT NULL DEFAULT '0.00',
`BZ` varchar(200) DEFAULT NULL,
PRIMARY KEY (`MXID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CKGL_DJZD` (
`DJID` int(4) NOT NULL AUTO_INCREMENT,
`DJBH` varchar(20) NOT NULL,
`DM_CZLX` int(4) NOT NULL,
`BZR` varchar(20) NOT NULL,
`BZRQ` datetime NOT NULL,
`DM_YJBZ` tinyint(2) NOT NULL DEFAULT '0',
PRIMARY KEY (`DJID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `CKGL_KCXX` (
`KCID` int(4) NOT NULL AUTO_INCREMENT,
`WLID` int(4) NOT NULL,
`PH` varchar(20) NOT NULL,
`SL` int(11) NOT NULL,
`JE` decimal(18,2) NOT NULL DEFAULT '0.00',
PRIMARY KEY (`KCID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

//物料增
curl --location --request POST 'localhost:9999/wl/create' \
--header 'Content-Type: application/json' \
--data-raw '{
"WLDH": "代号",
"WLMC": "名称",
"WLGG": "规格",
"WLDW": "单位",
"TPLJ": "图片"
}'

//物料减
curl --location --request GET 'localhost:9999/wl/delete?wlId=1'

//入库
curl --location --request POST 'localhost:9999/kc/update' \
--header 'Content-Type: application/json' \
--data-raw '{
"WLID": "2",
"SL": 1,
"PH": "PH",
"DJ": "2.01",
"DM_CZLX": "201",
"BZR": "韩非凡"
}'

//出库

curl --location --request POST 'localhost:9999/kc/update' \
--header 'Content-Type: application/json' \
--data-raw '{
"WLID": "2",
"SL": 1,
"PH": "PH",
"DJ": "2.01",
"DM_CZLX": "202",
"BZR": "feifan"
}'