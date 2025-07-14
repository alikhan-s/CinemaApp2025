package com.JavaProject.CinemaTicketBooking2.dao;

import com.JavaProject.CinemaTicketBooking2.model.Cinema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaDAOImpl implements CinemaDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Cinema> findAll() {
        List<Cinema> cinemas = new ArrayList<>();
        String sql = "SELECT * FROM cinemas";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setId(rs.getLong("id"));
                cinema.setName(rs.getString("name"));
                cinema.setLocation(rs.getString("location"));
                cinemas.add(cinema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cinemas;
    }

    @Override
    public Cinema findById(Long id) {
        String sql = "SELECT * FROM cinemas WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Cinema cinema = new Cinema();
                cinema.setId(rs.getLong("id"));
                cinema.setName(rs.getString("name"));
                cinema.setLocation(rs.getString("location"));
                return cinema;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Cinema cinema) {
        String sql = "INSERT INTO cinemas (name, location) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cinema.getName());
            ps.setString(2, cinema.getLocation());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Cinema cinema) {
        String sql = "UPDATE cinemas SET name = ?, location = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cinema.getName());
            ps.setString(2, cinema.getLocation());
            ps.setLong(3, cinema.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM cinemas WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
