SELECT * FROM v_jogador
SELECT * FROM v_partida
SELECT * FROM v_partidajogadores vp 

CALL sp_cadJogador('José', 'direita', 'atacante', 1.77, 67.00, '2025-12-01', 'brasileiro', '2005-7-13') 

CALL sp_cadpartida('2024-10-6', '19:30', 'FAS', 'Estádio Roxo') 

--partidaId, jogadorId, #gols
CALL sp_cadpartidajogadores(1, 1, 2) 
CALL sp_cadpartidajogadores(1, 2, 1) 

CALL sp_cadpartidajogadores(2, 1, 0) 

