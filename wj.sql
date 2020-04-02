/*
Navicat MySQL Data Transfer

Source Server         : wj
Source Server Version : 80015
Source Host           : localhost:3306
Source Database       : wj

Target Server Type    : MYSQL
Target Server Version : 80015
File Encoding         : 65001

Date: 2020-04-02 22:03:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_menu`;
CREATE TABLE `admin_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(64) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `name_zh` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `icon_cls` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `component` varchar(64) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin_menu
-- ----------------------------
INSERT INTO `admin_menu` VALUES ('1', '/admin', 'AdminIndex', '首页', 'el-icon-s-home', 'AdminIndex', '0');
INSERT INTO `admin_menu` VALUES ('2', '/admin/dashboard', 'DashboardAdmin', '运行情况', null, 'dashboard/admin/index', '1');
INSERT INTO `admin_menu` VALUES ('3', '/admin', 'User', '用户管理', 'el-icon-user', 'AdminIndex', '0');
INSERT INTO `admin_menu` VALUES ('4', '/admin', 'Content', '内容管理', 'el-icon-tickets', 'AdminIndex', '0');
INSERT INTO `admin_menu` VALUES ('5', '/admin', 'System', '系统配置', 'el-icon-s-tools', 'AdminIndex', '0');
INSERT INTO `admin_menu` VALUES ('6', '/admin/user/profile', 'Profile', '用户信息', null, 'user/UserProfile', '3');
INSERT INTO `admin_menu` VALUES ('7', '/admin/user/role', 'Role', '角色配置', null, 'user/Role', '3');
INSERT INTO `admin_menu` VALUES ('8', '/admin/content/book', 'BookManagement', '图书管理', null, 'content/BookManagement', '4');
INSERT INTO `admin_menu` VALUES ('9', '/admin/content/banner', 'BannerManagement', '广告管理', null, 'content/BannerManagement', '4');
INSERT INTO `admin_menu` VALUES ('10', '/admin/content/article', 'ArticleManagement', '文章管理', null, 'content/ArticleManagement', '4');
INSERT INTO `admin_menu` VALUES ('11', '/admin/personal', 'PersonalIndex', '个人信息', null, 'dashboard/admin/PersonalIndex', '1');
INSERT INTO `admin_menu` VALUES ('12', '/admin/updatePassword', 'UpdatePassword', '修改密码', null, 'dashboard/admin/UpdatePassword', '1');

-- ----------------------------
-- Table structure for admin_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_permission`;
CREATE TABLE `admin_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `desc_` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_permission
-- ----------------------------
INSERT INTO `admin_permission` VALUES ('1', 'users_management', '用户管理', '/api/admin/user');
INSERT INTO `admin_permission` VALUES ('2', 'roles_management', '角色管理', '/api/admin/role');
INSERT INTO `admin_permission` VALUES ('3', 'content_management', '内容管理', '/api/admin/content');

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name_zh` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('1', 'sysAdmin', '系统管理员', '1');
INSERT INTO `admin_role` VALUES ('2', 'contentManager', '内容管理员', '1');
INSERT INTO `admin_role` VALUES ('3', 'visitor', '访客', '1');
INSERT INTO `admin_role` VALUES ('9', 'test', '测试角色', '1');

-- ----------------------------
-- Table structure for admin_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_menu`;
CREATE TABLE `admin_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `mid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin_role_menu
-- ----------------------------
INSERT INTO `admin_role_menu` VALUES ('1', '1', '1');
INSERT INTO `admin_role_menu` VALUES ('2', '1', '2');
INSERT INTO `admin_role_menu` VALUES ('3', '1', '3');
INSERT INTO `admin_role_menu` VALUES ('4', '1', '4');
INSERT INTO `admin_role_menu` VALUES ('5', '1', '5');
INSERT INTO `admin_role_menu` VALUES ('6', '1', '6');
INSERT INTO `admin_role_menu` VALUES ('7', '2', '1');
INSERT INTO `admin_role_menu` VALUES ('8', '2', '2');
INSERT INTO `admin_role_menu` VALUES ('9', '1', '7');
INSERT INTO `admin_role_menu` VALUES ('10', '1', '8');
INSERT INTO `admin_role_menu` VALUES ('11', '2', '4');
INSERT INTO `admin_role_menu` VALUES ('12', '2', '8');
INSERT INTO `admin_role_menu` VALUES ('19', '4', '1');
INSERT INTO `admin_role_menu` VALUES ('20', '4', '2');
INSERT INTO `admin_role_menu` VALUES ('21', '3', '1');
INSERT INTO `admin_role_menu` VALUES ('22', '3', '2');
INSERT INTO `admin_role_menu` VALUES ('23', '9', '1');
INSERT INTO `admin_role_menu` VALUES ('24', '9', '2');

-- ----------------------------
-- Table structure for admin_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `admin_role_permission`;
CREATE TABLE `admin_role_permission` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `rid` int(20) DEFAULT NULL,
  `pid` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_permission_role_1` (`rid`),
  KEY `fk_role_permission_permission_1` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role_permission
-- ----------------------------
INSERT INTO `admin_role_permission` VALUES ('6', '2', '3');
INSERT INTO `admin_role_permission` VALUES ('80', '1', '1');
INSERT INTO `admin_role_permission` VALUES ('81', '1', '2');
INSERT INTO `admin_role_permission` VALUES ('82', '1', '3');
INSERT INTO `admin_role_permission` VALUES ('83', '5', '3');

-- ----------------------------
-- Table structure for admin_user_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_user_role`;
CREATE TABLE `admin_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_operator_role_operator_1` (`uid`),
  KEY `fk_operator_role_role_1` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_user_role
-- ----------------------------
INSERT INTO `admin_user_role` VALUES ('3', '3', '2');
INSERT INTO `admin_user_role` VALUES ('28', '1', '1');
INSERT INTO `admin_user_role` VALUES ('36', '2', '3');
INSERT INTO `admin_user_role` VALUES ('37', '2', '9');
INSERT INTO `admin_user_role` VALUES ('38', '24', '3');
INSERT INTO `admin_user_role` VALUES ('39', '25', '3');
INSERT INTO `admin_user_role` VALUES ('40', '36', '9');
INSERT INTO `admin_user_role` VALUES ('41', '37', '3');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cover` varchar(255) DEFAULT '',
  `title` varchar(255) NOT NULL DEFAULT '',
  `author` varchar(255) DEFAULT '',
  `date` varchar(20) DEFAULT '',
  `press` varchar(255) DEFAULT '',
  `abs` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `readtimes` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_book_category_on_cid` (`cid`),
  CONSTRAINT `fk_book_category_on_cid` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'https://i.loli.net/2019/04/10/5cadaa0d0759b.jpg', '且在人间', '余秀华', '2019-2-1', '湖南文艺出版社', '诗人余秀华中篇小说首次结集出版。\r\n\r\n        《且在人间》——以余秀华为生活原型，讲述一个残疾女人悲苦倔强、向死而生的故事。\r\n\r\n        女主人公周玉生活在乡村，患有“脑瘫”，她几乎被所有人漠视，甚至被整个社会抛弃，但是她渴望被当成一个普通的健康人,而不是带着怜悯或不屑，她只要求平等。爱情的缺 失，家庭的不幸，生活的种种际遇让周玉用诗歌的方式把 情感抒发出来，最终她用诗歌创作出了一个文学的世界，得到了人们的认可。', '2', '4');
INSERT INTO `book` VALUES ('2', 'https://i.loli.net/2019/04/10/5cada7e73d601.jpg', '三体', '刘慈欣', ' 2008-1', '重庆出版社', '文化大革命如火如荼进行的同时。军方探寻外星文明的绝秘计划“红岸工程”取得了突破性进展。但在按下发射键的那一刻，历经劫难的叶文洁没有意识到，她彻底改变了人类的命运。地球文明向宇宙发出的第一声啼鸣，以太阳为中心，以光速向宇宙深处飞驰……\r\n\r\n四光年外，“三体文明”正苦苦挣扎——三颗无规则运行的太阳主导下的百余次毁灭与重生逼迫他们逃离母星。而恰在此时。他们接收到了地球发来的信息。在运用超技术锁死地球人的基础科学之后。三体人庞大的宇宙舰队开始向地球进发……\r\n\r\n人类的末日悄然来临。', '2', '11');
INSERT INTO `book` VALUES ('32', 'https://i.loli.net/2019/04/10/5cada99bd8ca5.jpg', '叙事的虚构性', '[美] 海登·怀特 ', '2019-3', '南京大学出版社', '海登•怀特被誉为人类伟大的思想家之一。从1973年出版具有里程碑意义的专著《元史学》以来，怀特的作品对于历史学、文学研究、人类学、哲学、艺术史、电影传媒研究等将叙事学作为关注焦点的学科而言意义非凡。\n\n本书由罗伯特•多兰作序，他巧妙地将怀特重要但难得一见的文章汇集成册，研究探讨他关于历史书写和叙事的革命性理论。怀特的这些文章大多采用论文体，内容涉及多位思想家，探讨诸多主题，文笔犀利，语言优美。\n\n《叙事的虚构性》追溯怀特重要思想的演变轨迹，是历史编纂学者和学习者、历史理论和文学研究学者们的重要读物。', '3', '2');
INSERT INTO `book` VALUES ('35', 'https://i.loli.net/2019/04/10/5cada940e206a.jpg', '圣母', '[日]秋吉理香子 ', '2019-3', '新星出版社', '一起男童被害案搅得蓝出市人心惶惶。\n\n好不容易怀孕生产的保奈美抱紧年幼的孩子，立誓要不惜任何代价保护她。\n\n男人是在孩子出生后才成为父亲的，但女人，是从小生命来到体内的那一瞬间起，就是母亲了。患有不孕症的保奈美是经历过艰辛的治疗过程才终于有了孩子的，她不允许这起命案威胁到宝贵的孩子！\n\n母亲，就是要消除所有对子女的威胁，每一位母亲都应肩负这样的使命，这是神圣的天职！', '1', '5');
INSERT INTO `book` VALUES ('37', 'https://i.loli.net/2019/04/10/5cada8986e13a.jpg', '奢侈与逸乐', '[英]马克辛·伯格', '2019-3', '中国工人出版社', '本书探讨了十八世纪英国新式、时尚的消费品的发明、制造和购买。', '3', '0');
INSERT INTO `book` VALUES ('38', 'https://i.loli.net/2019/04/10/5cada8b8a3a17.jpg', '忧伤动物', '[德]莫妮卡·马龙 ', '2019-4', '漓江出版社', '“忧伤动物”(animal triste)这个词组取自一句最早可以追溯到亚里士多德时代的拉丁语名言，即“欢爱后，每个动物都忧伤不已”（Post coitum omne animal triste est）。无疑，这部冠以如此标题的小说让人有不祥的预感并暗示着宿命的思想。小说的女主人公是位近乎百岁的老人。在多年前有意斩断了与外界的一切联系之后，在她的后半生里，她唯一能做的就是或躺或坐在“印着鲜红、艳绿和深紫色的大花”、让人想起“食肉植物的花朵”的床单上，追忆几十年前她和自己...', '1', '2');
INSERT INTO `book` VALUES ('54', 'https://i.loli.net/2019/04/10/5cada9d9d23a6.jpg', '爱界', '[英] 费伊·韦尔登 ', '2019-3-1', '人民文学出版社', '去不去爱，爱的界限何在，一直是普拉克西丝的人生课题。\n\n年迈的她独自待在肮脏而昏暗的地下室里，想写回忆录，可她该写些什么呢？是写父母未婚同居生下了她，她还年幼天真无邪时，母女就遭父亲抛弃？还是写她曾经或是主动或是被动地成了未婚同居者、妻子、情人、母亲、后母？还是写她两年的牢狱生活？她想描绘二十世纪女性的众生相，想记录女性群体在情感、灵魂和思想方面所处的三重困境，想道出女性之间的大爱如何铸成姐妹之谊。', '3', '2');
INSERT INTO `book` VALUES ('55', 'https://i.loli.net/2019/04/10/5cada824c7119.jpg', '密室中的旅行', '[美] 保罗·奥斯特 ', '2019-3', '九州出版社', '一旦被抛进这个世界，我们就永远不会消失，即使造物者已经死去。\n\n.\n\n布兰克先生发现自己被囚禁在一个陌生的房间里，对过去的身份和经历一无所知。桌上有四叠六英寸厚的文稿，其中有一份未完待续的囚犯自述；还有一叠似曾相识的照片，照片中的人物将逐一登场。他续写了那个囚犯的故事，却发现自己正在经历的一切也早已被记录在文稿中……', '1', '1');
INSERT INTO `book` VALUES ('59', 'https://i.loli.net/2019/04/10/5cada87fd5c72.jpg', '基本穿搭', '[日]大山旬 ', '2019-3', '四川人民出版社', '对穿衣搭配感到不耐烦，认为时尚很麻烦，穿什么都可以或者对衣服有着自己的想法但不够自信，本书就是为这样的人而准备的穿衣指南。不需要追随瞬息万变的时尚潮流，也不需要烦恼色彩搭配，只要掌握最低限度的知识和备齐常规单品，谁都能完成清爽得体的 80分搭配。', '4', '2');
INSERT INTO `book` VALUES ('60', 'https://i.loli.net/2019/04/10/5cada976927da.jpg', '冒牌人生', '陈思安', '2019-4', '四川文艺出版社', '《冒牌人生》收录了十篇短篇小说。十个故事分别以城市中的怪人为主角，他们默默无闻地生存在城市主流生活的边缘地带：或是等待手术的性别认同障碍者，或是武艺高强而深藏不露的夜市摊主，或是卧底追凶的底层保安，或是甘于...', '1', '4');
INSERT INTO `book` VALUES ('61', 'https://i.loli.net/2019/04/10/5cada9202d970.jpg', '战争哀歌', '[越]保宁 ', '2019-4', '湖南文艺出版社', '《战争哀歌》超越了战争，战争是它的背景，它的内核是关于逝去的青春，关于美和伤痛！\n\n一场突如其来的战争打碎了阿坚和阿芳这对年轻情侣的生活，在血肉横飞的战争中，主人公阿坚成了幸存者，但战争带来的伤痛还远远没有平息。那些经历仍旧萦绕在阿坚的生活之中，被战争毁灭的不仅 仅是阿坚， 阿芳也遭遇了难以想象的梦魇。时间越长，阿坚越觉得自己不是活着，而是被困在这人世间。', '1', '6');
INSERT INTO `book` VALUES ('62', 'https://i.loli.net/2019/04/10/5cada9c852298.jpg', '胡椒的全球史', '[美] 玛乔丽·谢弗 ', '2019-3', '上海三联出版社', '看似不起眼的胡椒，却是家家餐桌必备。在中世纪时，更是欧洲达官显贵们的最爱、财富与地位的象征。黑胡椒原产于印度，距离欧洲各港口有十万八千里之远，取之向来不易。商人们对其供应来源不遗余力的追寻，成为世界史上一股重要的推动力量，促成全球贸易的兴起，重新划定了世界经济版图。', '2', '4');
INSERT INTO `book` VALUES ('63', 'https://i.loli.net/2019/04/10/5cada962c287c.jpg', '与病对话', '胡冰霜', '2019-3-31', '北京联合出版公司', '一部融合科普性与趣味性、兼具心理学与哲学意味的医学散文。\n\n一位满怀仁心的资深医者对几十年行医生涯的回望与省思。\n\n全书以真实的病例和鲜活的故事贯穿始终，作者从一位全科医生、心理学者的视角观察、解读疾病与患者身心之关系，厘清大众对诸多常见疾病的误解...', '1', '6');
INSERT INTO `book` VALUES ('64', 'https://i.loli.net/2019/04/10/5cada858e6019.jpg', '上帝笑了99次', '[英]彼得·凯弗', '2019-2', '北京联合出版公司', '一只美洲羊驼会坠入爱河吗？机器人能变成人吗？怎样才能不赢得公主青睐？人类一思考，上帝就发笑。在99个奇妙、怪诞、滑稽的问题背后，其实是99个烧脑的哲学、道德、法律领域的经典悖论，也是99道极富挑战性的大思考测试。本书内容覆盖了大多数常见哲学话题，包括形而上学、逻辑学、伦理学、语言哲学、政治哲学、自我认知、人际关系、美学、存在主义等，还配有20多幅漫画插图。在锻炼思维之外，本书也能帮我们建立个性化的哲学知识体系。', '3', '12');
INSERT INTO `book` VALUES ('65', 'https://i.loli.net/2019/04/10/5cada8e1aa892.jpg', '互联网算法', '[美] 菲斯曼等 ', '2019-4', '江西人民出版社', '只要你租过房子、上网买过东西、自己经营过企业，那么你就处在商业变革的前线。在这场变革中，亚马逊、谷歌、优步等不同以往的企业取得了史无前例的成功，而促成这场变革的不只是科技进步，还有经济学思想。\n\n在这本趣味横生的书中，我们会看到，经济思想的革命远比科技革命更宏大。从谷歌广告的算法，到网上购物规避欺诈，都要依靠经济学家建立的经济模型，甚至连互联网公司...', '6', '0');
INSERT INTO `book` VALUES ('66', 'https://i.loli.net/2019/04/10/5cada9ec514c9.jpg', '七侯笔录', '马伯庸', '2019-4-15', '湖南文艺出版社', '一个关于文化的离奇故事，一段关于文人的壮丽传说。\n\n几千年来，每一位风华绝代的文人墨客辞世之时，都会让自己的灵魂寄寓在一管毛笔之中。他们身躯虽去，才华永存，这些伟大的精神凝为性情不一的笔灵，深藏于世间，只为一句“不教天下才情付诸东流”的誓言。其中最伟大的七位古人，他们所凝聚的七管笔灵，被称为“管城七侯”。\n\n一位不学无术的现代少年，无意中邂逅了李白的青莲笔，命运就此与千年之前的诗仙交织一处，并为他开启了一个叫作笔冢的神秘世界。', '3', '24');
INSERT INTO `book` VALUES ('67', 'https://i.loli.net/2019/04/10/5cada9870c2ab.jpg', '中心与边缘', '[美] 希尔斯', '2019-3', '译林出版社', '美国著名社会学家爱德华·希尔斯的主要研究成果包括他对“克里斯玛”、“中心”和“边缘”等概念的解释，以及他对“大众社会”一词的修正，这些研究对分析政治和文化领导力以及社会凝聚力具有重要价值。本书对希尔斯数十载社会理论研究进行了全面而详细的总结，为解释与探究当代社会的结构与变化提供了极具科学性的参考依据。', '3', '12');
INSERT INTO `book` VALUES ('68', 'https://i.loli.net/2019/04/10/5cad643643d4c.jpg', '水浒群星闪耀时', '李黎', '2019-4', '上海文艺出版社', '本书以众所周知的梁山英雄为写作对象，重点书写其上山后、招安前的日常生活，涉及他们的喜怒哀乐、同类中人、乡愁怀旧、未来憧憬、命运追问等。书中涉及宋江、武松、鲁智深、李俊、燕青等等耳熟能详的人物而显得有些“改编”与水浒研究的意味，但鉴于所有人物皆为虚构，本书稿的内容是虚构之上的虚构，旨在宏大叙事的语境下突出个人的细微之处和命运感。', '1', '28');
INSERT INTO `book` VALUES ('69', 'https://i.loli.net/2019/04/10/5cad63931ce27.jpg', '谋杀狄更斯', '[美] 丹·西蒙斯 ', '2019-4', '上海文艺出版社', '“狄更斯的那场意外灾难发生在1865年6月9日，那列搭载他的成功、平静、理智、手稿与情妇的火车一路飞驰，迎向铁道上的裂隙，突然触目惊心地坠落了。”', '1', '26');
INSERT INTO `book` VALUES ('70', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3872188661,2639386985&fm=26&gp=0.jpg', '像艺术家一样思考', '[英] 威尔·贡培兹', '2019-4', '湖南美术出版社', '归纳成就艺术大师的 10 个关键词\n\n揭示大师们的创作秘辛\n\n凝聚 BBC 艺术频道主编威尔·贡培兹职业生涯的所见、所知、所想\n\n·\n\n威尔·贡培兹是你能遇到的最好的老师\n\n——《卫报》', '3', '24');
INSERT INTO `book` VALUES ('107', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2725767190,1919502560&fm=26&gp=0.jpg', '物理', '李好', '1998.02.07', '人民出版社', '', '1', '29');
INSERT INTO `book` VALUES ('108', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585507706312&di=f12b852e524bbcf0f3c55c8e4566e9e0&imgtype=0&src=http%3A%2F%2Fbbs.jooyoo.net%2Fattachment%2FMon_0905%2F24_65548_2835f8eaa933ff6.jpg', '你好', '你好', '1998.2.8', '人民出版社', '你好', '6', '11');
INSERT INTO `book` VALUES ('109', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1585507706310&di=c6ffbc80310a02d8ff2cad4d8c828e37&imgtype=0&src=http%3A%2F%2Fa4.att.hudong.com%2F55%2F91%2F01300534888406136270917323337.jpg', '活着真难', '无名', '2020.3.30', '自家出版社', '无名', '2', '16');

-- ----------------------------
-- Table structure for book_recommand
-- ----------------------------
DROP TABLE IF EXISTS `book_recommand`;
CREATE TABLE `book_recommand` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `book_condition` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `result_books` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of book_recommand
-- ----------------------------
INSERT INTO `book_recommand` VALUES ('1', '[66]', '[68]');
INSERT INTO `book_recommand` VALUES ('2', '[68]', '[66]');
INSERT INTO `book_recommand` VALUES ('3', '[66]', '[69]');
INSERT INTO `book_recommand` VALUES ('4', '[69]', '[66]');
INSERT INTO `book_recommand` VALUES ('5', '[66]', '[70]');
INSERT INTO `book_recommand` VALUES ('6', '[70]', '[66]');
INSERT INTO `book_recommand` VALUES ('7', '[1]', '[2]');
INSERT INTO `book_recommand` VALUES ('8', '[2]', '[1]');
INSERT INTO `book_recommand` VALUES ('9', '[68]', '[69]');
INSERT INTO `book_recommand` VALUES ('10', '[69]', '[68]');
INSERT INTO `book_recommand` VALUES ('11', '[70]', '[68]');
INSERT INTO `book_recommand` VALUES ('12', '[68]', '[70]');
INSERT INTO `book_recommand` VALUES ('13', '[70]', '[69]');
INSERT INTO `book_recommand` VALUES ('14', '[69]', '[70]');
INSERT INTO `book_recommand` VALUES ('15', '[66]', '[68, 69]');
INSERT INTO `book_recommand` VALUES ('16', '[68]', '[66, 69]');
INSERT INTO `book_recommand` VALUES ('17', '[66, 68]', '[69]');
INSERT INTO `book_recommand` VALUES ('18', '[69]', '[66, 68]');
INSERT INTO `book_recommand` VALUES ('19', '[66, 69]', '[68]');
INSERT INTO `book_recommand` VALUES ('20', '[68, 69]', '[66]');
INSERT INTO `book_recommand` VALUES ('21', '[66]', '[70, 68]');
INSERT INTO `book_recommand` VALUES ('22', '[70]', '[66, 68]');
INSERT INTO `book_recommand` VALUES ('23', '[66, 70]', '[68]');
INSERT INTO `book_recommand` VALUES ('24', '[68]', '[66, 70]');
INSERT INTO `book_recommand` VALUES ('25', '[66, 68]', '[70]');
INSERT INTO `book_recommand` VALUES ('26', '[70, 68]', '[66]');
INSERT INTO `book_recommand` VALUES ('27', '[66]', '[70, 69]');
INSERT INTO `book_recommand` VALUES ('28', '[70]', '[66, 69]');
INSERT INTO `book_recommand` VALUES ('29', '[66, 70]', '[69]');
INSERT INTO `book_recommand` VALUES ('30', '[69]', '[66, 70]');
INSERT INTO `book_recommand` VALUES ('31', '[66, 69]', '[70]');
INSERT INTO `book_recommand` VALUES ('32', '[70, 69]', '[66]');
INSERT INTO `book_recommand` VALUES ('33', '[70]', '[68, 69]');
INSERT INTO `book_recommand` VALUES ('34', '[68]', '[70, 69]');
INSERT INTO `book_recommand` VALUES ('35', '[70, 68]', '[69]');
INSERT INTO `book_recommand` VALUES ('36', '[69]', '[70, 68]');
INSERT INTO `book_recommand` VALUES ('37', '[69, 70]', '[68]');
INSERT INTO `book_recommand` VALUES ('38', '[68, 69]', '[70]');
INSERT INTO `book_recommand` VALUES ('39', '[66]', '[70, 68, 69]');
INSERT INTO `book_recommand` VALUES ('40', '[70]', '[66, 68, 69]');
INSERT INTO `book_recommand` VALUES ('41', '[66, 70]', '[68, 69]');
INSERT INTO `book_recommand` VALUES ('42', '[68]', '[66, 70, 69]');
INSERT INTO `book_recommand` VALUES ('43', '[66, 68]', '[70, 69]');
INSERT INTO `book_recommand` VALUES ('44', '[70, 68]', '[66, 69]');
INSERT INTO `book_recommand` VALUES ('45', '[66, 70, 68]', '[69]');
INSERT INTO `book_recommand` VALUES ('46', '[69]', '[66, 70, 68]');
INSERT INTO `book_recommand` VALUES ('47', '[66, 69]', '[70, 68]');
INSERT INTO `book_recommand` VALUES ('48', '[70, 69]', '[66, 68]');
INSERT INTO `book_recommand` VALUES ('49', '[66, 70, 69]', '[68]');
INSERT INTO `book_recommand` VALUES ('50', '[68, 69]', '[66, 70]');
INSERT INTO `book_recommand` VALUES ('51', '[66, 68, 69]', '[70]');
INSERT INTO `book_recommand` VALUES ('52', '[70, 68, 69]', '[66]');
INSERT INTO `book_recommand` VALUES ('53', '[1]', '[35]');
INSERT INTO `book_recommand` VALUES ('54', '[35]', '[1]');
INSERT INTO `book_recommand` VALUES ('55', '[1]', '[69]');
INSERT INTO `book_recommand` VALUES ('56', '[69]', '[1]');
INSERT INTO `book_recommand` VALUES ('57', '[35]', '[69]');
INSERT INTO `book_recommand` VALUES ('58', '[69]', '[35]');
INSERT INTO `book_recommand` VALUES ('59', '[1]', '[35, 69]');
INSERT INTO `book_recommand` VALUES ('60', '[35]', '[1, 69]');
INSERT INTO `book_recommand` VALUES ('61', '[1, 35]', '[69]');
INSERT INTO `book_recommand` VALUES ('62', '[69]', '[1, 35]');
INSERT INTO `book_recommand` VALUES ('63', '[1, 69]', '[35]');
INSERT INTO `book_recommand` VALUES ('64', '[35, 69]', '[1]');

-- ----------------------------
-- Table structure for book_to_users
-- ----------------------------
DROP TABLE IF EXISTS `book_to_users`;
CREATE TABLE `book_to_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) DEFAULT NULL,
  `users_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '',
  `users_id_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of book_to_users
-- ----------------------------
INSERT INTO `book_to_users` VALUES ('71', '35', '', '0');
INSERT INTO `book_to_users` VALUES ('72', '38', '', '0');
INSERT INTO `book_to_users` VALUES ('73', '55', '', '0');
INSERT INTO `book_to_users` VALUES ('74', '60', '', '0');
INSERT INTO `book_to_users` VALUES ('75', '61', '', '0');
INSERT INTO `book_to_users` VALUES ('76', '63', '', '0');
INSERT INTO `book_to_users` VALUES ('77', '68', '24', '1');
INSERT INTO `book_to_users` VALUES ('78', '69', '', '0');
INSERT INTO `book_to_users` VALUES ('79', '107', '24', '1');
INSERT INTO `book_to_users` VALUES ('80', '1', '', '0');
INSERT INTO `book_to_users` VALUES ('81', '2', '', '0');
INSERT INTO `book_to_users` VALUES ('82', '62', '24', '1');
INSERT INTO `book_to_users` VALUES ('83', '109', '', '0');
INSERT INTO `book_to_users` VALUES ('84', '32', '', '0');
INSERT INTO `book_to_users` VALUES ('85', '37', '', '0');
INSERT INTO `book_to_users` VALUES ('86', '54', '', '0');
INSERT INTO `book_to_users` VALUES ('87', '64', '', '0');
INSERT INTO `book_to_users` VALUES ('88', '66', '', '0');
INSERT INTO `book_to_users` VALUES ('89', '67', '', '0');
INSERT INTO `book_to_users` VALUES ('90', '70', '24', '1');
INSERT INTO `book_to_users` VALUES ('91', '59', '', '0');
INSERT INTO `book_to_users` VALUES ('92', '65', '', '0');
INSERT INTO `book_to_users` VALUES ('93', '108', '24 36', '2');

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '文学');
INSERT INTO `category` VALUES ('2', '流行');
INSERT INTO `category` VALUES ('3', '文化');
INSERT INTO `category` VALUES ('4', '生活');
INSERT INTO `category` VALUES ('5', '经管');
INSERT INTO `category` VALUES ('6', '科技');

-- ----------------------------
-- Table structure for jotter_article
-- ----------------------------
DROP TABLE IF EXISTS `jotter_article`;
CREATE TABLE `jotter_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `article_title` varchar(255) DEFAULT NULL,
  `article_content_html` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `article_content_md` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `article_abstract` varchar(255) DEFAULT NULL,
  `article_cover` varchar(255) DEFAULT NULL,
  `article_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of jotter_article
-- ----------------------------

-- ----------------------------
-- Table structure for top_book
-- ----------------------------
DROP TABLE IF EXISTS `top_book`;
CREATE TABLE `top_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_id` int(11) NOT NULL DEFAULT '0',
  `read_times` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of top_book
-- ----------------------------
INSERT INTO `top_book` VALUES ('63', '2', '11');
INSERT INTO `top_book` VALUES ('64', '1', '4');
INSERT INTO `top_book` VALUES ('65', '62', '4');
INSERT INTO `top_book` VALUES ('66', '69', '24');
INSERT INTO `top_book` VALUES ('67', '70', '18');
INSERT INTO `top_book` VALUES ('68', '68', '20');
INSERT INTO `top_book` VALUES ('69', '66', '24');
INSERT INTO `top_book` VALUES ('70', '107', '26');
INSERT INTO `top_book` VALUES ('71', '35', '4');
INSERT INTO `top_book` VALUES ('72', '60', '3');
INSERT INTO `top_book` VALUES ('73', '63', '6');
INSERT INTO `top_book` VALUES ('74', '61', '5');
INSERT INTO `top_book` VALUES ('75', '67', '12');
INSERT INTO `top_book` VALUES ('76', '32', '1');
INSERT INTO `top_book` VALUES ('77', '54', '2');
INSERT INTO `top_book` VALUES ('78', '108', '11');
INSERT INTO `top_book` VALUES ('79', '109', '18');
INSERT INTO `top_book` VALUES ('80', '55', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `major` int(11) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_waijian` (`major`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '35b9529f89cfb9b848060ca576237e17', '8O+vDNr2sI3N82BI31fu1A==', '管理员', '11122223333123', '1', '1', '文学');
INSERT INTO `user` VALUES ('2', 'test', '85087738b6c1e1d212683bfafc163853', 'JBba3j5qRykIPJQYTNNH9A==', '测试', '44455556666', '1', '1', '文学');
INSERT INTO `user` VALUES ('3', 'editor', '8583a2d965d6159edbf65c82d871fa3e', 'MZTe7Qwf9QgXBXrZzTIqJQ==', '编辑', null, '1', '1', '文学');
INSERT INTO `user` VALUES ('24', 'zjr', '8b0a44d24f5dab18e909dec9fc79d841', 't0jBG86iYZMvGcocA4cxjQ==', '小刘', '110', '1', '1', '文学');
INSERT INTO `user` VALUES ('25', 'zjr1', '3fb4436956c3859736f01e1cd82943da', 'vYWC007I5m9K+mPVhZJvIw==', '小张', '111', '1', '1', '文学');
INSERT INTO `user` VALUES ('26', 'zjr2', '6cb61e8923b46398cd2d6c1afb4bb213', 'vjUp1NpTgD/xD+z78Fo/6w==', '小朱', '112', '1', '1', '文学');
INSERT INTO `user` VALUES ('34', 'zjr4', 'ca034882f6794d1dc521713b9513be2f', 's0ErTwDku1V3TfWmnbYLJA==', '小马', '113', '1', '1', '文学');
INSERT INTO `user` VALUES ('36', 'zjr8', '68b5d9aac65837d361e16bca8f51d57c', 'tnqe5E5m0OJjM4Czu5exvg==', '小夏', '114', '5', '1', '经管');
INSERT INTO `user` VALUES ('37', 'zjr9', '7a1ac91069849b94689f471843daf65a', 'lsIlJbAwThnkXvQsjyGjsQ==', '好', '99999', '4', '1', '生活');

-- ----------------------------
-- Table structure for user_book
-- ----------------------------
DROP TABLE IF EXISTS `user_book`;
CREATE TABLE `user_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `read_times` int(11) NOT NULL DEFAULT '0',
  `book_id` int(11) NOT NULL DEFAULT '0',
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_book
-- ----------------------------
INSERT INTO `user_book` VALUES ('160', '24', '3', '108', '6');
INSERT INTO `user_book` VALUES ('161', '24', '1', '107', '1');
INSERT INTO `user_book` VALUES ('162', '24', '1', '70', '3');
INSERT INTO `user_book` VALUES ('163', '24', '1', '68', '1');
INSERT INTO `user_book` VALUES ('164', '24', '1', '62', '2');
INSERT INTO `user_book` VALUES ('165', '36', '1', '108', '6');

-- ----------------------------
-- Table structure for user_to_books
-- ----------------------------
DROP TABLE IF EXISTS `user_to_books`;
CREATE TABLE `user_to_books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT '0',
  `books_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT '',
  `books_id_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_to_books
-- ----------------------------
INSERT INTO `user_to_books` VALUES ('30', '24', '108 107 70 68 62', '5');
INSERT INTO `user_to_books` VALUES ('31', '36', '108', '1');
