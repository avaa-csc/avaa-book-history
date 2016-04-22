create index IX_162B3615 on khl_Kartoituskohde (kohdeid);
create index IX_66CF2C9F on khl_Kartoituskohde (vkid);

create index IX_44B24A27 on khl_Kuntainfo (kuntaid);
create index IX_F22D5EF9 on khl_Kuntainfo (vkid);

create index IX_B2EFB17B on khl_Maakuntainfo (maakuntaid);
create index IX_EE3546AC on khl_Maakuntainfo (vkid);

create index IX_1549759 on khl_Vanhatkirjat (kohdeid);
create index IX_2CEEF1DB on khl_Vanhatkirjat (vkid);

create index IX_8CEC51F7 on khl_Vanhatkirjat_Kartoituskohde (kohdeid);
create index IX_89BC6BFD on khl_Vanhatkirjat_Kartoituskohde (vkid);

create index IX_7603C905 on khl_Vanhatkirjat_Kuntainfo (kuntaid);
create index IX_C7F17CDB on khl_Vanhatkirjat_Kuntainfo (vkid);

create index IX_145211D9 on khl_Vanhatkirjat_Maakuntainfo (maakuntaid);
create index IX_1F86C58A on khl_Vanhatkirjat_Maakuntainfo (vkid);

create index IX_6A3E94E5 on khl_Vanhatkirjat_kuntainfo (kuntaid);
create index IX_DD2D3CFB on khl_Vanhatkirjat_kuntainfo (vkid);

create index IX_38663B3A on khl_kuntaid (kuntaid);
create index IX_54B8AE15 on khl_kuntaid (maakuntaid);
create index IX_E7363EC6 on khl_kuntaid (vkid);

create index IX_A362B008 on khl_maakuntaid (maakuntaid);
create index IX_763972F9 on khl_maakuntaid (vkid);