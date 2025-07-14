package com.JavaProject.CinemaTicketBooking2.dao;

import com.JavaProject.CinemaTicketBooking2.model.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ViewerDAOImpl implements ViewerDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public List<Viewer> findAll() {
        List<Viewer> viewers = new ArrayList<>();
        String sql = "SELECT * FROM viewers";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Viewer viewer = new Viewer();
                viewer.setId(rs.getLong("id"));
                viewer.setName(rs.getString("name"));
                viewer.setAge(rs.getInt("age"));
                viewers.add(viewer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return viewers;
    }

    @Override
    public Viewer findById(Long id) {
        String sql = "SELECT * FROM viewers WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Viewer viewer = new Viewer();
                viewer.setId(rs.getLong("id"));
                viewer.setName(rs.getString("name"));
                viewer.setAge(rs.getInt("age"));
                return viewer;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void save(Viewer viewer) {
        String sql = "INSERT INTO viewers (name, age) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, viewer.getName());
            ps.setInt(2, viewer.getAge());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Viewer viewer) {
        String sql = "UPDATE viewers SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, viewer.getName());
            ps.setInt(2, viewer.getAge());
            ps.setLong(3, viewer.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM viewers WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
