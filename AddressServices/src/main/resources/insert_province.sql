SELECT * FROM `micro-busbooking-address`.province;
SELECT * FROM `micro-busbooking-address`.district;

INSERT INTO `micro-busbooking-address`.province(`name`, `eng_code`) VALUES
('Hà Nội','ha_noi'),
('Hà Giang','ha_giang'),
('Cao Bằng','cao_bang'),
('Bắc Kạn','bac_kan'),
('Tuyên Quang','tuyen_quang'),
('Lào Cai','lao_cai'),
('Điện Biên','dien_bien'),
('Lai Châu','lai_chau'),
('Sơn La','son_la'),
('Yên Bái','yen_bai'),
('Hoà Bình','hoa_binh'),
('Thái Nguyên','thai_nguyen'),
('Lạng Sơn','lang_son'),
('Quảng Ninh','quang_ninh'),
('Bắc Giang','bac_giang'),
('Phú Thọ','phu_tho'),
('Vĩnh Phúc','vinh_phuc'),
('Bắc Ninh','bac_ninh'),
('Hải Dương','hai_duong'),
('Hải Phòng','hai_phong'),
('Hưng Yên','hung_yen'),
('Thái Bình','thai_binh'),
('Hà Nam','ha_nam'),
('Nam Định','nam_dinh'),
('Ninh Bình','ninh_binh'),
('Thanh Hóa','thanh_hoa'),
('Nghệ An','nghe_an'),
('Hà Tĩnh','ha_tinh'),
('Quảng Bình','quang_binh'),
('Quảng Trị','quang_tri'),
('Thừa Thiên Huế','thua_thien_hue'),
('Đà Nẵng','da_nang' ),
('Quảng Nam','quang_nam'),
('Quảng Ngãi','quang_ngai'),
('Bình Định','binh_dinh'),
('Phú Yên','phu_yen'),
('Khánh Hòa','khanh_hoa'),
('Ninh Thuận','ninh_thuan'),
('Bình Thuận','binh_thuan'),
('Kon Tum','kon_tum'),
('Gia Lai','gia_lai'),
('Đắk Lắk','dak_lak'),
('Đắk Nông','dak_nong'),
('Lâm Đồng','lam_dong'),
('Bình Phước','binh_phuoc'),
('Tây Ninh','tay_ninh'),
('Bình Dương','binh_duong'),
('Đồng Nai','dong_nai'),
('Bà Rịa - Vũng Tàu','ba_ria_vung_tau'),
('Hồ Chí Minh','ho_chi_minh'),
('Long An','long_an'),
('Tiền Giang','tien_giang'),
('Bến Tre','ben_tre'),
('Trà Vinh','tra_vinh'),
('Vĩnh Long','vinh_long'),
('Đồng Tháp','dong_thap'),
('An Giang','an_giang'),
('Kiên Giang','kien_giang'),
('Cần Thơ','can_tho'),
('Hậu Giang','hau_giang'),
('Sóc Trăng','soc_trang'),
('Bạc Liêu','bac_lieu'),
('Cà Mau','ca_mau');

 -- huyện ở hà nội 
INSERT INTO  `micro-busbooking-address`.district(`name`, `eng_code`,`province_id`) VALUES
('Ba Đình','ba_dinh','1'),
('Hoàn Kiếm','hoan_kiem','1'),
('Tây Hồ','tay_ho','1'),
('Long Biên','long_bien','1'),
('Cầu Giấy','cau_giay','1'),
('Đống Đa','dong_da','1'),
('Hai Bà Trưng','hai_ba_trung','1'),
('Hoàng Mai','hoang_mai','1'),
('Thanh Xuân','thanh_xuan','1'),
('Sóc Sơn','soc_son','1'),
('Đông Anh','dong_anh','1'),
('Gia Lâm','gia_lam','1'),
('Nam Từ Liêm','nam_tu_liem','1'),
('Thanh Trì','thanh_tri','1'),
('Bắc Từ Liêm','bac_tu_liem','1'),

-- các huyện của khánh hòa
('Nha Trang','nha_trang','37'),
('Cam Ranh','cam_ranh','37'),
('Cam Lâm','cam_lam','37'),
('Vạn Ninh','van_ninh','37'),
('Ninh Hòa','ninh_hoa','37'),
('Khánh Vĩnh','khanh_vinh','37'),
('Diên Khánh','dien_khanh','37'),
('Khánh Sơn','khanh_son','37'),
('Trường Sa','truong_sa','37');

-- các xã huyện vạn ninh
INSERT INTO  `micro-busbooking-address`.ward(`name`,`eng_code`,`district_id`) values
('Vạn Giã','van_gia',19),
('Đại Lãnh','dai_lanh',19),
('Vạn Phước','van_phuoc',19),
('Vạn Long','van_long',19),
('Vạn Bình','van_binh',19),
('Vạn Thọ','van_tho',19),
('Vạn Khánh','van_khanh',19),
('Vạn Phú','van_phu',19),
('Vạn Lương','van_luong',19); 


