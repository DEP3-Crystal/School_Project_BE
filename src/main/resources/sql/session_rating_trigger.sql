CREATE OR REPLACE FUNCTION update_session_ratings_sum()
RETURNS TRIGGER AS $$
BEGIN
  IF (TG_OP = 'INSERT') THEN
    UPDATE sessions
    SET rating_sum = rating_sum + NEW.rating, rating_count = rating_count + 1
    WHERE session_id = NEW.session_id;
  ELSIF (TG_OP = 'UPDATE') THEN
    UPDATE sessions
    SET rating_sum = rating_sum - OLD.rating + NEW.rating
    WHERE session_id = NEW.session_id;
  END IF;
  RETURN NULL;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER update_sessions_rating_sum
AFTER INSERT OR UPDATE ON session_ratings
FOR EACH ROW
EXECUTE PROCEDURE update_session_ratings_sum();
