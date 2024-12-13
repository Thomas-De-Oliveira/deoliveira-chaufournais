CREATE MATERIALIZED VIEW party_user_stats AS
SELECT
    p.party_id,
    p.name AS party_name,
    COUNT(pa.user_id) AS current_user_count,
    p.number_max_participate AS _user_count,
    u.username AS organiser_name
FROM
    party p
        LEFT JOIN
    participate pa ON p.party_id = pa.party_id
        LEFT JOIN
    users u ON pa.user_id = u.user_id AND pa.organiser = TRUE
GROUP BY
    p.party_id, p.name, p.number_max_participate, u.username;
